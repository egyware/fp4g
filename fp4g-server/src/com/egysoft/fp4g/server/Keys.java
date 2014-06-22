package com.egysoft.fp4g.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class Keys 
{
	private static final int KEY_LENGHT = 2048;
	private final PublicKey publicKey;
	private final PrivateKey privateKey;
	private final String portablePublicKey;

	private Keys(PublicKey publicKey, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException
	{		
		this.privateKey = privateKey;
		this.publicKey  = publicKey;
		
		KeyFactory fact = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec  pub  = fact.getKeySpec(publicKey, RSAPublicKeySpec.class);		
		this.portablePublicKey = String.format("%s,%s",pub.getModulus().toString(16),pub.getPublicExponent().toString(16));
	}
	
	public static Keys getInstance()
	{
		try 
		{
			String publicKeyFilename = Configuration.getProperty(Configuration.PUBLIC_KEY);
			String privateKeyFilename = Configuration.getProperty(Configuration.PRIVATE_KEY);
			File  publicKeyFile = new File(publicKeyFilename);
			File privateKeyFile = new File(privateKeyFilename);
			if(publicKeyFile.exists() && privateKeyFile.exists()) //ambos deben existir
			{
				KeyFactory fact = KeyFactory.getInstance("RSA");
				PublicKey  publicKey  = readPublicKeyFromFile(fact, publicKeyFile);
				PrivateKey privateKey = readPrivateKeyFromFile(fact, privateKeyFile);
				
				return new Keys(publicKey, privateKey);
			}
			else
			{
				KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			
				kpg.initialize(KEY_LENGHT);
				
				KeyPair kp = kpg.genKeyPair();
				
				PublicKey  publicKey  = kp.getPublic();
				PrivateKey privateKey = kp.getPrivate();
				
				//save keys
				KeyFactory fact = KeyFactory.getInstance("RSA");
				RSAPublicKeySpec  pub  = fact.getKeySpec(kp.getPublic(),  RSAPublicKeySpec.class);
				RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(), RSAPrivateKeySpec.class);
				
				saveToFile(publicKeyFile,   pub.getModulus(),  pub.getPublicExponent());
				saveToFile(privateKeyFile, priv.getModulus(), priv.getPrivateExponent());
				
				return new Keys(publicKey, privateKey);
			}
		}
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Key getPublicKey()
	{			
		return publicKey;
	}
	
	public Key getPrivateKey()
	{	
		return privateKey;
	}	
	
	private static void saveToFile(File file,  BigInteger mod, BigInteger exp) throws IOException 
	{
	  ObjectOutputStream out = null;
	  try 
	  {
		  out = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(file)));
		  out.writeObject(mod);
		  out.writeObject(exp);
	  }
	  finally 
	  {
	    if(out != null) out.close();
	  }
	}

	private static PublicKey readPublicKeyFromFile(KeyFactory fact, File file) throws IOException
	{  
		ObjectInputStream ois = null;  
		try 
		{  
		  FileInputStream fis = new FileInputStream(file);  
		  ois = new ObjectInputStream(fis);  
	     
		  BigInteger modulus  = (BigInteger) ois.readObject();  
		  BigInteger exponent = (BigInteger) ois.readObject();		  
	     
	      //Get Public Key  
	      RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
	      PublicKey publicKey = fact.generatePublic(rsaPublicKeySpec);  
	              
	      return publicKey; 
		}
		catch(Exception e)
		{
			throw new IOException("Error inesperado",e);
		}
		finally
		{  
			if(ois != null) ois.close();
		}		  
	}  
	private static PrivateKey readPrivateKeyFromFile(KeyFactory fact, File file) throws IOException
	{  
		ObjectInputStream ois = null;  
		try 
		{  
			FileInputStream fis = new FileInputStream(file);  
			ois = new ObjectInputStream(fis);  
	     
			BigInteger modulus = (BigInteger) ois.readObject();  
			BigInteger exponent = (BigInteger) ois.readObject();  
	     
			//Get Private Key  
			RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
			PrivateKey privateKey = fact.generatePrivate(rsaPrivateKeySpec);  
	              
			return privateKey;  
	    } 
		catch (Exception e) 
		{  
			throw new IOException("Error inesperado",e);
		}  
		finally
		{  
			if(ois != null) ois.close();
		}  
	}

	public String portablePublicKey() 
	{
		return portablePublicKey;		
	}  
}
