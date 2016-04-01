package com.example.viraj.designlibrary;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by tasneem on 23/7/15.
 */
public class DesidimeInstanceIDListenerService extends InstanceIDListenerService {
    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. This call is initiated by the
     * InstanceID provider.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Fetch updated Instance ID token and notify our app's server of any changes (if applicable).

    }
    // [END refresh_token]
}