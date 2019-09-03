package springprograms;

import org.springframework.context.annotation.Primary;

@Primary
public class Address implements ForQualifier 
{
     
	@Override
	public void value() {
		System.out.println("Address is calling");
	}

}
