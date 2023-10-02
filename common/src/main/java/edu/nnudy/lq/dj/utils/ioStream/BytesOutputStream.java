package edu.nnudy.lq.dj.utils.ioStream;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class BytesOutputStream extends OutputStream {
	private byte[] bufferedO;
	private int countO;
	
	public BytesOutputStream() {
		this.bufferedO = new byte[256];
	}
	
	public BytesOutputStream(final int size) {
		this.bufferedO = new byte[Math.max(size, 0)];
	}
	
	@Override
	public void write(final int b) {
		if ( this.countO >= this.bufferedO.length ) {
			final var copied = new byte[this.bufferedO.length << 1];
			System.arraycopy(this.bufferedO, 0, copied, 0, this.countO);
			this.bufferedO = copied;
		}
		this.bufferedO[this.countO++] = (byte) b;
	}
	
	@Override
	public void write(final byte @NotNull [] b, final int offset, final int length) {
		if ( length == 1 ) this.write(b[offset]);
		else {
			if ( this.countO + length >= this.bufferedO.length ) {
				final var copied = new byte[(this.countO + length) << 1];
				System.arraycopy(this.bufferedO, 0, copied, 0, this.countO);
				this.bufferedO = copied;
			}
			System.arraycopy(b, offset, this.bufferedO, this.countO, length);
			this.countO += length;
		}
	}
	
	@Override
	public void write(final byte @NotNull [] b) {
		if ( this.countO + b.length >= this.bufferedO.length ) {
			final var copied = new byte[(this.countO + b.length) << 1];
			System.arraycopy(this.bufferedO, 0, copied, 0, this.countO);
			this.bufferedO = copied;
		}
		System.arraycopy(b, 0, this.bufferedO, this.countO, b.length);
		this.countO += b.length;
	}
	
	public void writeTo(final OutputStream out) throws IOException {
		out.write(this.bufferedO, 0, this.countO);
	}
	
	public int size() {
		return this.countO;
	}
	
	public BytesInputStream createBytesInputStream() {
		return new BytesInputStream(this.bufferedO, 0, this.countO);
	}
	
	@Override
	public String toString() {
		return new String(this.bufferedO, 0, this.countO);
	}
	
	public String toString(final Charset charset) {
		return new String(this.bufferedO, 0, this.countO, charset);
	}
}
