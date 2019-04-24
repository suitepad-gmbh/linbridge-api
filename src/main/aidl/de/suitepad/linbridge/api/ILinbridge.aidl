// ILinbridge.aidl
package de.suitepad.linbridge.api;

// Declare any non-default types here with import statements
import de.suitepad.linbridge.api.ILinbridgeListener;
import de.suitepad.linbridge.api.SIPConfiguration;
import de.suitepad.linbridge.api.core.CallError;
import de.suitepad.linbridge.api.core.AuthenticationState;
import de.suitepad.linbridge.api.core.Credentials;

interface ILinbridge {

     /**
     * authenticate to a sip server
     */
    void authenticate(in Credentials credentials);

    /**
    * get currently used credentials
    */
    Credentials getCurrentCredentials();

     /**
     * update the current SIP client configuration
     */
    void updateConfig(in SIPConfiguration configuration);

     /**
     * get current SIP configuration
     */
    SIPConfiguration getConfig();

    /**
     *  get the current authentication state
     */
    AuthenticationState getAuthenticationState();

     /**
     * registers an ILinSipListener, will override current listener if force is set to true
     * returns true if listener registration succeeded
     */
    void registerSipListener(ILinbridgeListener listener);

     /**
     * stops the current service
     */
    void stopService();

     /**
     * initiate call with destination address (could be a number as well as a sip address)
     */
    CallError call(String destination);

    CallError answerCall();

    CallError rejectCall();

     /**
     * will send dtmf to current call and play dtmf sound until stopdtmf is called or another dtmf is sent
     */
    void sendDtmf(char number);

     /**
     * will stop currently playing dtmf
     */
    void stopDtmf();

     /**
     * mute / unmute current call
     */
    void mute(boolean muted);

}
