package cdu.xeon.forum.dto;


public class AjaxObj {
	
	private int result;
	
	private String msg;
	
	private Object obj;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public AjaxObj() {
		result = 1;
	}
	public AjaxObj(int result, String msg, Object obj) {
		super();
		this.result = result;
		this.msg = msg;
		this.obj = obj;
	}
	public AjaxObj(int result, String msg) {
		super();
		this.result = result;
		this.msg = msg;
	}
	public AjaxObj(int result) {
		super();
		this.result = result;
	}
	
}
