package cn.onestravel.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.Date;

/**
 * Toast 提示工具类
 */
public class ToastUtil {
	private static long preShowTimes = 0;//前一个消息显示的时间
	private static String preShowMsg = null;//前一个消息显示的内容
	private static long space = 6L;//相同消息显示的时间间隔

	public static long getSpace() {
		return space;
	}

	/**
	 *
	 * @param space 相同消息显示的时间间隔 单位：s(秒)
	 */
	public static void setSpace(long space) {
		ToastUtil.space = space;
	}

	/**
	 * 显示消息，时间较短
	 * @param context
	 * @param message
	 */
	public static void showShortToast(Context context, String message){
		if (isShow(message)) {
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 显示消息，时间较长
	 * @param context
	 * @param message
	 */
	public static void showLongToast(Context context, String message){
		if (isShow(message)) {
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	}


	/**
	 * 判断提示信息是否要显示
	 * @param msg
	 * @return
	 */
	private static boolean isShow(String msg) {

		long nowTimes = new Date().getTime();
		long diffTimes = nowTimes - preShowTimes;
		if (TextUtils.isEmpty(msg) ||
				(diffTimes < space * 1000 && !TextUtils.isEmpty(msg) && msg.equals(preShowMsg))
				) {
			return false;
		} else {
			preShowTimes = new Date().getTime();
			preShowMsg = msg;
			return true;
		}
	}

}
