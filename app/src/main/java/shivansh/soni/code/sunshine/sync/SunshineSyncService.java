package shivansh.soni.code.sunshine.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by shivansh.
 */

public class SunshineSyncService extends Service {

    private static final Object sSyncAdapterLock=new Object();
    private static SunshineSyncAdapter sunshineSyncAdapter=null;

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (sSyncAdapterLock){
            if(sunshineSyncAdapter == null)
                sunshineSyncAdapter=new SunshineSyncAdapter(getApplicationContext(),true);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sunshineSyncAdapter.getSyncAdapterBinder();
    }
}
