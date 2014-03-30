package com.snid.safeway;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.snid.safeway.request.RequestAdapter;

public class BaseActivity extends Activity
{
	protected RequestAdapter req;
	protected int req_type = 0;
	
	protected ProgressDialog prog;
	
	protected static final int REQ_SEND_SMS				= 100;
	protected static final int REQ_CHECK_AUTH			= 101;
	protected static final int REQ_DEVICE_REGISTRATION	= 102;
	protected static final int REQ_KEEP_ALIVE			= 103;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		this.req = new RequestAdapter();
		
		// prepare progress dialog
		prog = new ProgressDialog(this);
		prog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		prog.setCancelable(false);
		setProgressMessage(R.string.msg_send_request);
	}
	
	protected void setProgressMessage(int res_id)
	{
		prog.setMessage(getResources().getString(res_id));
	}
}
