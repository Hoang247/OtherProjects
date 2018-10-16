//Hoang Nguyen
//PSA7B
public class PSA7B
{
    
    public static void main (String[] args)
    {
     // FileChooser.setMediaPath("C:/Users/Hoang/Desktop/Java");
     // String f = FileChooser.getMediaPath("Sound1.wav");
      Sound s1 = new Sound("Sound1.wav");
      Sound s2 = new Sound("Sound2.wav");
      Sound s3 = new Sound("Sound3.wav");
      s1.concatenation(s2, s3, 100000);
      s1.blockingPlay();
      
      
      
      
    }
}