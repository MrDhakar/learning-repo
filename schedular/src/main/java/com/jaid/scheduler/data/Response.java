package com.jaid.scheduler.data;

public class Response <T>{
	
	private  String success;
    private  String message;
    private T data;

    public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Response(String message, T data, String success) {
		this.message=message;
		this.data=data;
		this.success = success;
	}

	@SuppressWarnings("unchecked")
	public static <T> Response<T> empty(){
        return Response.<T>builder()
                .success("false")
                .message("")
                .data(null)
                .build();
    }

    @SuppressWarnings("unchecked")
	public static <T> Response<T> success(T data){
        return Response.<T>builder()
                .success("true")
                .message("Record saved.")
                .data(data)
                .build();
    }

    @SuppressWarnings("unchecked")
	public static <T> Response<T> error(T data){
        return Response.<T>builder()
                .success("false")
                .message("error")
                .build();
    }

    @SuppressWarnings("unchecked")
	public static <T> Response<T> success(T data, String message){
        return Response.<T>builder()
                .success("true")
                .message(message)
                .data(data)
                .build();
    }

    @SuppressWarnings("unchecked")
	public static <T> Response<T> error(T data, String message){
        return Response.<T>builder()
                .success("false")
                .message(message)
                .build();
    }

	
	public static <T> ResponseBuilder<T> builder() {
 		return new ResponseBuilder<T>();
 	}

	
}