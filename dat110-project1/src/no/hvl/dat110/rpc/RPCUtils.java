package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length() + 1];

		// TODO: marshall RPC identifier and string into byte array

		encoded[0] = rpcid;
		for (int i = 0; i < str.length(); i++) {
			encoded[i+1] = str.getBytes()[i];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded
		decoded = new String(data, 1, data.length - 1);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type

		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type

		// TODO: return rcpid?

		byte rpcid = data[0];

		data = new byte[] {rpcid};

	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] byteX = ByteBuffer.allocate(4).putInt(x).array();
		byte[] encoded = new byte[5];

		// TODO: marshall RPC identifier and string into byte array

		encoded[0] = rpcid;

		for (int i = 0; i < byteX.length; i++) {
			encoded[i+1] = byteX[i];
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		// TODO: unmarshall integer contained in data

		return ByteBuffer.wrap(data, 1, 4).getInt();

	}
}
