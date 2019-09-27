// ILinbridge.aidl
package de.suitepad.linbridge.api;

// Declare any non-default types here with import statements
import de.suitepad.linbridge.api.ILinbridgeListener;
import de.suitepad.linbridge.api.AudioConfiguration;
import de.suitepad.linbridge.api.core.CallError;
import de.suitepad.linbridge.api.core.AuthenticationState;
import de.suitepad.linbridge.api.core.Credentials;
import de.suitepad.linbridge.api.core.CallEndReason;

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
    void updateConfig(in AudioConfiguration configuration);

     /**
     * get current SIP configuration
     */
    AudioConfiguration getConfig();

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

     /**
     * returns the current call duration or -1 if there's no current call
     */
    int getCurrentCallDuration();

     /**
     * return last call end reason, call end reason is set to none when a new call is placed
     */
    CallEndReason getCallEndReason();

     /**
     * sets the user id for debbuging purposes
     */
    void setUserId(String id);

    /**
    * returns true if microphone is muted
    */
    boolean isMuted();

}
