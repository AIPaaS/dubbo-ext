package com.ai.dubbo.ext.filter;

import com.ai.dubbo.ext.vo.BaseResponse;
import com.ai.paas.ipaas.PaaSConstant;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.google.gson.Gson;

@Activate(group = { Constants.CONSUMER })
public class ClientExceptionConverter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) {
		// 获取访问协议
		String protocol = invoker.getUrl().getProtocol();
		// 执行结果
		Result result = null;
		result = invoker.invoke(invocation);
		// 这里需要处理在rest协议下如果方法本身成功，又没有返回的情况
		if (null != protocol && protocol.equalsIgnoreCase("rest")) {
			Object obj = result.getValue();
			if (null != obj && obj instanceof BaseResponse) {
				BaseResponse ex = (BaseResponse) obj;
				if (null != ex.getResultCode()
						&& !ex.isSuccess()
						&& ex.getResultCode().equalsIgnoreCase(
								PaaSConstant.ExceptionCode.SYSTEM_ERROR)) {
					// 是异常类，需要抛出新的异常
					RuntimeException t = new RuntimeException(
							ex.getResultMsg());
					if (null != ex.getInfo()) {
						Gson gson = new Gson();
						t.setStackTrace(gson.fromJson(ex.getInfo().toString(),
								StackTraceElement[].class));
					}
					throw t;
				}
			}
		}
		return result;

	}
}