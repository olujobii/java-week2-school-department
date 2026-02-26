package com.olujobii.util;

import java.util.Random;

public class IdGeneratorUtil {
    private  static final Random RANDOM = new Random();

    public static String idGeneration(String prefix){
        return(prefix+"-"+RANDOM.nextInt(1,1000));
    }
}
