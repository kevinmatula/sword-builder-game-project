//music will be imported and played from here
import javax.sound.sampled.*;
import  java.io.*;
public class Music
{
	static Clip fightMusic, buildMusic, deathMusic;
	public static void loadMusic()
	{

		try
		{
			File audioFileKey = new File("AUDIO_1485.wav").getAbsoluteFile();
			AudioInputStream audioInputStreamKey = AudioSystem.getAudioInputStream(audioFileKey);
			fightMusic= AudioSystem.getClip();
			fightMusic.open(audioInputStreamKey);

			File audioFileKey1 = new File("AUDIO_2619.wav").getAbsoluteFile();
			AudioInputStream audioInputStreamKey1 = AudioSystem.getAudioInputStream(audioFileKey1);
			buildMusic= AudioSystem.getClip();
			buildMusic.open(audioInputStreamKey1);

			File audioFileKey2 = new File("deathSound.wav").getAbsoluteFile();
			AudioInputStream audioInputStreamKey2 = AudioSystem.getAudioInputStream(audioFileKey2);
			deathMusic= AudioSystem.getClip();
			deathMusic.open(audioInputStreamKey2);
		}
		catch(Exception e)
		{
			System.out.println("Fail");
		}
	}

	public static void stopFightMusic()
	{
		fightMusic.stop();
	}

	public static void playFightMusic()
	{
		fightMusic.start();
	}

	public static void playBuildMusic()
	{
		buildMusic.start();
	}

	public static void stopBuildMusic()
	{
		buildMusic.stop();
	}

	public static void playDeathMusic()
	{
		deathMusic.start();
	}

	public static void stopDeathMusic()
	{
		deathMusic.stop();
	}
	//Making music work. In the triggering method, put object.start(); to make it play.
	//To make it loop, do object.loop(Clip.LOOP_CONTINUOUSLY);
	//If it's a sound effect and you need it to restart each time do object.setMicrosecondPosition(0); first, then start();


	//does not work on repl (use textpad for testing music)
	//must be WAV file



	// import javax.sound.sampled.*;
	// import java.io.*;



}