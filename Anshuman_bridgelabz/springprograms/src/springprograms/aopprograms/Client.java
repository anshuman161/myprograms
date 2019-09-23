/*
 * package springprograms.aopprograms;
 * 
 * import org.springframework.aop.framework.ProxyFactoryBean;
 * 
 * public class Client { public static void main(String[] args) { Bank bank =
 * new Bank(); // create target LogBeforeService log = new LogBeforeService();
 * // add target ProxyFactoryBean pfb = new ProxyFactoryBean(); // target+advice
 * to proxy pfb.setTarget(bank); pfb.addAdvice(log); Bank b = (Bank)
 * pfb.getObject(); int amount = b.deposite(5000, "sin12345");
 * System.out.println(amount); } }
 */