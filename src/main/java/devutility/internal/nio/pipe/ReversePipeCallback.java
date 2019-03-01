package devutility.internal.nio.pipe;

import java.nio.ByteBuffer;

/**
 * 
 * ReversePipeCallback
 * 
 * @author: Aldwin Su
 */
public interface ReversePipeCallback {
	void call(ByteBuffer byteBuffer);
}