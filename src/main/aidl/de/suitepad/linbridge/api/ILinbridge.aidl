// ILinbridge.aidl
package de.suitepad.linbridge.api;

// Declare any non-default types here with import statements
import de.suitepad.linbridge.api.ILinSipListener;
import de.suitepad.linbridge.api.SIPConfiguration;

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
    void forceRegisterSipListener(ILinSipListener listener);

     /**
     * register an ILinSipListener, returns true if listener registration succeeeded
     */
    boolean registerSipListener(ILinSipListener listener);

     /**
     * stops the current service
     */
    void stopService();

     /**
     * initiate call with destination address (could be a number as well as a sip address)
     */
    void call(String destination);

}
