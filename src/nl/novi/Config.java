package nl.novi;

public class Config {
    //     private static String version = "deploy";
    private static String version = "dev"; //development vs deployment
    private static String pathScoreFile=  "scoreBijHouden.txt";
    private static String pathSecureKeyFile =  "secure.key";


    public static String getVersion() {
        return version;
    }
    public static void setVersion(String version) {
        Config.version = version;
    }
    public static String getPathScoreFile() {
        return pathScoreFile;
    }
    public static void setPathScoreFile(String pathScoreFile) {
        Config.pathScoreFile = pathScoreFile;
    }
    public static String getPathSecureKeyFile() {
        return pathSecureKeyFile;
    }
    public static void setPathSecureKeyFile(String pathSecureKeyFile) {
        Config.pathSecureKeyFile = pathSecureKeyFile;
    }
}
