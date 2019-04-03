// ILinbridge.aidl
package de.suitepad.linbridge.api;

// Declare any non-default types here with import statements
import de.suitepad.linbridge.api.ILinbridgeListener;
import de.suitepad.linbridge.api.SIPConfiguration;
import de.suitepad.linbridge.api.core.CallError;

interface ILinbridge {

     /**
     * authenticate to a sip server
     */
    void authenticate(String host, int port, String username, String password, String proxy);

     /**
     * update the current SIP client configuration
     */
    void updateConfig(in SIPConfiguration configuration);

     /**
     * get current SIP configuration
     */
    SIPConfiguration getConfig();

     /**
     * registers an ILinSipListener, will override current listener if force is set to true
     * returns true if listener registration succeeded
     */
    void forceRegisterSipListener(ILinbridgeListener listener);

     /**
     * register an ILinSipListener, returns true if listener registration succeeeded
     */
    boolean registerSipListener(ILinbridgeListener listener);

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

}
