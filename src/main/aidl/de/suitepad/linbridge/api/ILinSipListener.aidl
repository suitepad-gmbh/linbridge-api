// ILinSipListener.aidl
package de.suitepad.linbridge.api;

// Declare any non-default types here with import statements
import de.suitepad.linbridge.api.core.CallState;
import de.suitepad.linbridge.api.core.AuthenticationState;

interface ILinSipListener {

    void callStateChanged(in CallState callState);

    void authenticationStateChanged(in AuthenticationState authenticationState);

}
