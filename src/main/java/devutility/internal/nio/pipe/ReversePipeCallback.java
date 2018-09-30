package devutility.internal.nio.pipe;

import java.nio.ByteBuffer;

public interface ReversePipeCallback {
	void call(ByteBuffer byteBuffer);
}