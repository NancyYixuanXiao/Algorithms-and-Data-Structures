package leetCodeJava;

public class CanWinNim {

	public static boolean canWinNim(int n) {
        
//		if (n>0 && n<4) return true;
//		if (n == 4) return false;
//		
//		return (canWinNim(n-1) || canWinNim(n-2) || canWinNim(n-3));
		
//		return n%4 != 0;
		
		return (n&3) != 0;
		
    }
}
