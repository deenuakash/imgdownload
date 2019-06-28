package testSel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class imgDownload {
	WebDriver d;
  @Test
  public void ImageDownload() {
	  List <WebElement> link =d.findElements(By.tagName("img"));
	  System.out.println(link.size());
	  URL imgurl;int c=0;
	  for (int j = 0; j<link.size(); j++)
	  {
		  File dir=new File();
	 for (int i = 0; i<link.size(); i++)
	  {
		 if(!(link.get(i).getAttribute("src").equals(""))&& !(link.get(i).getAttribute("src")==null))
		 {
	  String urls=link.get(i).getAttribute("src");
	  String name=link.get(i).getAttribute("alt");
	  try {
	  imgurl =new URL(urls);
	  BufferedImage img = ImageIO.read(imgurl);
	  ImageIO.write(img, "jpg", new File(name + ".jpg"));
	  }
	  catch(Exception e) {}
	  }
	  }
	  }
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","/home/deenuakash/ChromeDriver/chromedriver");
	  d=new ChromeDriver();
	  d.manage().window().maximize();
	  d.get("https://squaredtvart.tumblr.com/");
  }

  @AfterClass
  public void afterClass() {
	  d.quit();
  }
}
