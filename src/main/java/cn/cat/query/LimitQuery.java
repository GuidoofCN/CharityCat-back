package cn.cat.query;

public class LimitQuery {
	private Integer start;
	private Integer total;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getTotal() {
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
