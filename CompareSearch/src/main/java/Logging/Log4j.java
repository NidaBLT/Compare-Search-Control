package Logging;

import java.util.logging.Logger;

public class Log4j {
         private static Logger Log = Logger.getLogger(Log4j.class.getName());

        public static void searchGoogle(String testClassName){
            Log.info("1. arama motorunda arama yapılır.");
        }
        public static void searchYandex (String testClassName){
            Log.info("2. arama motorunda arama yapılır.");
        }
        public static void parseGooglePage (String message) {
            Log.info("1. arama motorunda link, başlık ve açıklama ayrıştırılır.");
        }
        public static void parseYandexPage (String message) {
            Log.info("2. arama motorunda link, başlık ve açıklama ayrıştırılır.");
        }
         public static void compareSearchResults (String message) {
            Log.info("1. ve 2. arama motorundaki link, başlık ve açıklama metinleri karşılaştırılıp, aynı olanlar listelenir.");
        }

    }

