package Aspects;

import org.aspectj.lang.JoinPoint;

public class LoggingAspects {

    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("\n🟢 LoggingAspect: Method called -> " + joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("🔹 Arguments:");
            for (Object arg : args) {
                System.out.println("   ➤ " + arg);
            }
        }
    }
}
