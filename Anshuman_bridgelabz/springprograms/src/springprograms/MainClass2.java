package springprograms;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class MainClass2 
{
  @Bean
  public Demo demobean() 
  {
	  return new Demo();
  }
}
