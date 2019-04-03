// ILinbridgeListener.aidl
package de.suitepad.linbridge.api;

// Declare any non-default types here with import statements
import de.suitepad.linbridge.api.core.CallState;
import de.suitepad.linbridge.api.core.AuthenticationState;

interface ILinbridgeListener {

    void callStateChanged(in CallState callState, String farendId);

    void authenticationStateChanged(in AuthenticationState authenticationState);

}
