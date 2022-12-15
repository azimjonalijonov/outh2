package outh2.outh2;

import org.apache.catalina.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service public class userService {
    public UserEntity getData(AbstractAuthenticationToken authenticationToken){
        Map<String,Object> attribute;
        if(authenticationToken instanceof OAuth2AuthenticationToken){
            attribute =((OAuth2AuthenticationToken)authenticationToken).getPrincipal().getAttributes();
        }else {
            throw new IllegalArgumentException("error");
        }
        return getFrom(attribute);

    }

    public UserEntity getFrom(Map<String,Object> attribute){
        UserEntity user =new UserEntity();
        if(attribute.get("uid")!=null){
            user.setUid((String) attribute.get("uid"));
        }
        if(attribute.get("locale")!=null){
            user.setLangKey((String) attribute.get("locale"));
        }
        if(attribute.get("given_name")!=null){
            user.setFirstName((String) attribute.get("given_name"));
        }
        if(attribute.get("family_name")!=null){
            user.setLastName((String) attribute.get("family_name"));

        }
        return user;
    }
}
