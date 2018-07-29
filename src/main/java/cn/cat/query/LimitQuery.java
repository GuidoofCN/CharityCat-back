package cn.cat.query;

public class LimitQuery {
	private static int START = 0;//从第几条记录开始
	private static int TOTAL = 5;//每页显示的记录数
	private Integer start;
	private Integer total;

	public Integer getStart() {
		if(start == null){
			return START;
		}
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getTotal() {
		if(total == null){
			return TOTAL;
		}
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "LimitQuery [start=" + start + ", total=" + total + "]";
	}

}
