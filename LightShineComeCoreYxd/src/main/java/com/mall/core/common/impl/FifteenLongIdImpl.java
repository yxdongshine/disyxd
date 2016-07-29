package com.mall.core.common.impl;

import com.mall.core.common.FifteenLongId;

public class FifteenLongIdImpl implements FifteenLongId{

	private long pre_workerId;
	public static long workerId=13;
	private final static long twepoch = 1361753741828L;
	private long sequence = 0L;
	/**机器标识位数*/
	private final static long workerIdBits = 4L;
	/**机器ID最大值*/
	public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
	/**毫秒内自增位*/
	private final static long sequenceBits = 10L;
	/**机器ID偏左移12位*/
	private final static long workerIdShift = sequenceBits;
	/**时间毫秒左移22位*/
	private final static long timestampLeftShift = sequenceBits + workerIdBits;
	/**(用一句话描述这个变量表示什么)*/
	public final static long sequenceMask = -1L ^ -1L << sequenceBits;

	private long lastTimestamp = -1L;

	public FifteenLongIdImpl() {
		System.err.println("无参构造");
		init(workerId);
	}
	
	public FifteenLongIdImpl(long workerId) {
		System.err.println("AAAA有参构造" + workerId);
		init(workerId);
	}
	
	private void init(long workerId){
		if (workerId > this.maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",this.maxWorkerId));
		}
		this.workerId = workerId;
	}

	/* (non-Javadoc)
	 * @see com.mall.core.common.FifteenLongId#nextId()
	 */
	public synchronized long nextId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & this.sequenceMask;
			if (this.sequence == 0) {
				// System.out.println("###########" + sequenceMask);
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		if (timestamp < this.lastTimestamp) {
			try {
				throw new Exception(
						String.format(
								"Clock moved backwards.  Refusing to generate id for %d milliseconds",
								this.lastTimestamp - timestamp));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.lastTimestamp = timestamp;
		long nextId = ((timestamp - twepoch << timestampLeftShift))
				| (this.workerId << this.workerIdShift) | (this.sequence);
		// System.out.println("timestamp:" + timestamp + ",timestampLeftShift:"
		// + timestampLeftShift + ",nextId:" + nextId + ",workerId:"
		// + workerId + ",sequence:" + sequence);
		return nextId;
	}

	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
		System.out.println(maxWorkerId);
		FifteenLongIdImpl worker2 = new FifteenLongIdImpl(0);
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println("-----------------------------------------");

		worker2 = new FifteenLongIdImpl(10);
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println("-----------------------------------------");

		worker2 = new FifteenLongIdImpl(5);
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		worker2 = new FifteenLongIdImpl(5);
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println(worker2.nextId());
		System.out.println("-----------------------------------------");
	}

	public long getPre_workerId() {
		return pre_workerId;
	}

	public void setPre_workerId(long pre_workerId) {
		System.err.println("setPre_workerId*******************************"+pre_workerId);
		FifteenLongIdImpl.workerId = pre_workerId;
		this.pre_workerId = pre_workerId;
	}
	

}
