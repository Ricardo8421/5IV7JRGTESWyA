package des;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESven {
    
    public String cifrar(String tex, String cla, int id) {
        String mencif="";
        String tip="";
        if(id==0){
            tip="DES";
        }else{
            tip="AES";
        }
        SecretKeySpec lla = new SecretKeySpec(cla.getBytes(), tip);
        Cipher cifrador;
        try{
            cifrador = Cipher.getInstance(tip);
            cifrador.init(Cipher.ENCRYPT_MODE, lla);
            byte[] bytcif = cifrador.doFinal(tex.getBytes());
            mencif=new BASE64Encoder().encode(bytcif);
        }catch(Exception e){
            System.out.println("Error");
        }
        return mencif;
    }
    
    public String descifrar(String cif, String cla, int id){
        String tex="";
        String tip="";
        if(id==0){
            tip="DES";
        }else{
            tip="AES";
        }
        SecretKeySpec lla = new SecretKeySpec(cla.getBytes(), tip);
        Cipher cifrador;
        try{
            cifrador = Cipher.getInstance(tip);
            cifrador.init(Cipher.DECRYPT_MODE, lla);
            byte[] cifr=new BASE64Decoder().decodeBuffer(cif);
            byte[] bytdes = cifrador.doFinal(cifr);
            tex=new String(bytdes);
        }catch(Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return tex;
    }
}