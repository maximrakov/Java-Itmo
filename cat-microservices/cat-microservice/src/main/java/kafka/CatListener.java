package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import itmo.tech.main.entity.Cat;
import itmo.tech.main.entity.CatDTO;
import itmo.tech.main.entity.CatMapper;
import itmo.tech.main.entity.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import service.CatService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ComponentScan("itmo.tech.main.entity")
public class CatListener {

    CatService catService;
    CatMapper catMapper;

    @Autowired
    public CatListener(CatService catService, CatMapper catMapper) {
        this.catService = catService;
        this.catMapper = catMapper;
    }

    @KafkaListener(topics = "${kafka.request.topic}", groupId = "${kafka.group.id}")
    @SendTo
    public Object handle(RequestInfo requestInfo) {
        Object entity = null;
        List<CatDTO> catDTOList = new ArrayList<>();
        Method method = null;
        try {
            method = (CatService.class).getMethod(requestInfo.getMethodName(), getTypes(requestInfo.getArgs()));
            entity = method.invoke(catService, requestInfo.getArgs());
            if(entity.getClass().getSimpleName().equals("ArrayList")) {
                ((ArrayList<Cat>) entity).stream()
                        .forEach(e -> catDTOList.add(catMapper.toDTO(e)));
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if (entity.getClass().getSimpleName().equals("ArrayList")) {
            return catDTOList;
        }else {
            return catMapper.toDTO((Cat) entity);
        }
    }

    @KafkaListener(topics = "${kafka.simplereply.topic}", groupId = "${kafka.group.id}")
    public void handleCat(RequestInfo requestInfo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Cat saveCat = mapper.convertValue(requestInfo.getArgs()[0], Cat.class);
            (CatService.class).getMethod(requestInfo.getMethodName(), Cat.class)
                    .invoke(catService, saveCat);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private Class<?>[] getTypes(Object... args) {
        List<Class<?> > types = new ArrayList<>();
        Arrays.stream(args).forEach(e -> types.add(e.getClass()));
        return types.toArray(new Class<?>[0]);
    }
}