package com.example.Library.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Library.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService listProfileService;
    
    @GetMapping("/{userId}/allreviews")
    public List<String> showUsers(@PathVariable Long userId) {
         List<String> a = listProfileService.showUsers(userId);

        List<String> pauta = Arrays.asList("Username","Title", "Score","Review");

        return Ordenar(a, pauta);
    }
    
    @GetMapping("/{userId}")
    public List<String> showProfile(@PathVariable Long userId){
        List<String> a = listProfileService.showProfile(userId);

        List<String> pauta = Arrays.asList( "Title", "Score","Review");

        return Ordenar(a, pauta);
    }
    public List<String> Ordenar(List<String> datos, List<String> pauta){

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < datos.size(); i++) {
            int comasCount = 0;
            String Bonus ="";
            Bonus += pauta.get(comasCount) + ": ";
            
            String b= datos.get(i);

            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == ',' && comasCount < pauta.size()-1) {
                    ret.add(Bonus);
                    Bonus = pauta.get(comasCount+1)+ ": ";
                    comasCount++;
                }
                else{
                    Bonus += b.charAt(j);
                }
            }
            ret.add(Bonus);
            if (i < datos.size()-1) {
                Bonus = "-----------------------";
                ret.add(Bonus);
            }
        }

        return ret;

    }
}