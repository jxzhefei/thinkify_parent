package entity;

import java.util.List;

/**
 * @author INstamina
 * @date 2018年12月7日
 * @description 
 */
public class PageResult<T> {
	private Long total;
	private List<T> datas;
	
	/**
	 * 
	 */
	public PageResult() {
		
	}

	/**
	 * @param total
	 * @param datas
	 */
	public PageResult(Long total, List<T> datas) {
		this.total = total;
		this.datas = datas;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
}
