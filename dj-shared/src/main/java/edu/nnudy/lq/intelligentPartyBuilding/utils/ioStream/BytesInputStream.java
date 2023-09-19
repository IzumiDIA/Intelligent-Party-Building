package edu.nnudy.lq.intelligentPartyBuilding.utils.ioStream;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class BytesInputStream extends InputStream {
	private final byte[] bufferedI;
	private final int countI;
	private int position, mark = 0;
	
	public BytesInputStream(final byte[] bufferedI) {
		this.bufferedI = bufferedI;
		this.position = 0;
		this.countI = bufferedI.length;
	}
	
	public BytesInputStream(final byte[] bufferedI, final int offset, final int length) {
		this.bufferedI = bufferedI;
		this.position = offset;
		this.countI = Math.min(offset + length, bufferedI.length);
		this.mark = offset;
	}
	
	@Override
	public int read() {
		return (this.position < this.countI) ? (this.bufferedI[this.position++] & 0xff) : -1;
	}
	
	@Override
	public int read(final byte @NotNull [] b, final int offset, int length) {
		if ( this.position >= this.countI ) return -1;
		final var avail = this.countI - this.position;
		if ( length > avail ) length = avail;
		if ( length <= 0 ) return 0;
		System.arraycopy(this.bufferedI, this.position, b, offset, length);
		this.position += length;
		return length;
	}
	
	@Override
	public long transferTo(final OutputStream out) throws IOException {
		final var len = this.countI - this.position;
		out.write(this.bufferedI, this.position, len);
		this.position = this.countI;
		return len;
	}
	
	@Override
	public long skip(final long n) {
		long k = (long) this.countI - this.position;
		if ( n < k ) k = Math.max(n, 0);
		this.position += (int) k;
		return k;
	}
	
	@Override
	public int available() {
		return this.countI - this.position;
	}
	
	@Override
	public boolean markSupported() {
		return true;
	}
	
	@Override
	public void mark(final int ignored) {
		this.mark = this.position;
	}
	
	@Override
	public void reset() {
		this.position = this.mark;
	}
}
