
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound. 
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }
  
  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }
  
  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
 
  public static void main(String[] args)
  {
    Sound sound1 = new Sound(FileChooser.pickAFile());
    sound1.explore();
  }
             
  public void halfOther()
{
 SoundSample[] s = this.getSamples();
 SoundSample sample = null;
 int i = 0;
 int value = 0;
 while(i<s.length)
   {
    sample = s[i];
    value = sample.getValue();
    value /=2;
    sample.setValue(value);
    i += 2;
   };
}
  public void concatenation(Sound s1, Sound s2, int switchPoint)
  {
    SoundSample[] s1Array = s1.getSamples();
    SoundSample[] s2Array = s2.getSamples();
    SoundSample[] silenceArray = this.getSamples();
    SoundSample sample = null;
    int value;
    if(switchPoint>s1Array.length)
    {
      switchPoint = s1Array.length;
    }
    for(int i = 0; i<switchPoint; i++)
    {
      value = s1.getSampleValueAt(i);
      this.setSampleValueAt(i,value);
    }
    if(switchPoint+s2Array.length-1>silenceArray.length)
    {
    for(int i = switchPoint, j = 0; i<silenceArray.length; i++, j++)
    {
      value = s2.getSampleValueAt(j);
      this.setSampleValueAt(i, value);
    }
    }
    else
    {
      for(int i = switchPoint, j = 0; j<s2Array.length; i++, j++)
      {
        value = s2.getSampleValueAt(j);
        this.setSampleValueAt(i, value);
      }
      for(int i = s2Array.length+switchPoint;i<silenceArray.length; i++)
      {
        this.setSampleValueAt(i, 0);
      }
    }
  }
 public Sound reverse()
  {
    SoundSample[] sampleArray = this.getSamples();
    int length = sampleArray.length;
    Sound s2 = new Sound(length);
    int value;
    for(int i = length-1, j = 0; i>0; i--, j++)
    {
      value = this.getSampleValueAt(i);
      s2.setSampleValueAt(j, value);
    }
    return s2;
  }
    
    /* This method is to be used for Problem 3 of PSA7 */
public Sound soundPalindrome()
{
    Sound original = new Sound(this);
    Sound reverseSound = this.reverse();
    Sound emptySound = new Sound(this.getLength()*2);
    
    emptySound.concatenation(original, reverseSound, this.getLength());
    return emptySound;
}
    
} // this } is the end of class Sound, put all new methods before this