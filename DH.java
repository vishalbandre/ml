import java.util.*;

// Class to calculate the key for two persons

class DH {
  public static void main(String args[]) {
    /**
     * P & G are public keys
     * a & b are private keys
     */
    long P, G, x, a, y, b, ka, kb;
    
    // Create Scanner class object to take input from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Both the users should be agreed upon the public keys G and P");
    // Take inputs for public keys from the user
    System.out.println("Enter value for pub key G:");
    G = sc.nextLong();
    System.out.println("Enter value for pub key P:");
    P = sc.nextLong();

    // Get private keys inputs a and b selected by User 1 and User 2.
    System.out.println("Enter val for pvt key a selected by user 1: ");
    a = sc.nextLong();
    System.out.println("Enter val for pvt key b selected by user 2: ");
    b = sc.nextLong();

    // Generate x and y keys using calculatePower() method.
    x = cP(G, a, P);
    y = cP(G, b, P);

    // Generate ka and kb secrets after the echange of x and y keys
    // Calculate secret key for user 1
    ka = cP(y, a, P);
    // Calculate secret key for user 2
    kb = cP(x, b, P);

    // Print secret keys for users
    System.out.println("Secret key for u1: " + ka);
    System.out.println("Secret key for u2: " + kb);
  }

  // cP() method to find the value of x ^ y mod P
  private static long cP(long x, long y, long P) {
    long result = 0;
    if(y == 1) {
      return x;
    } else {
      result = ((long)Math.pow(x, y)) % P;
      return result;
    }
  }
}
