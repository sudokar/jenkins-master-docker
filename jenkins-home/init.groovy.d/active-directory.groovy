import jenkins.model.Jenkins
import hudson.plugins.active_directory.ActiveDirectorySecurityRealm
import hudson.plugins.active_directory.GroupLookupStrategy

def instance = Jenkins.getInstance()

def env = System.getenv()

println("=== Install the Security Realm")

//String domain = env['ACTIVE_DIRECTORY_DOMAIN']
String domain = 'group.williamhill.plc'
String server = 'ad-auth.dtc.prod.williamhill.plc'
//String site = env['ACTIVE_DIRECTORY_SITE']
// String bindName = 'cn=svcCX.sqabind,ou=Service Accounts,ou=Servers,ou=WILLIAMHILL,dc=Group,dc=WilliamHill,dc=PLC'
//String bindPassword = env['ACTIVE_DIRECTORY_BIND_PASSWORD']

def securityRealm = new ActiveDirectorySecurityRealm(domain, null, null, null, server, GroupLookupStrategy.AUTO)
//def securityRealm = new ActiveDirectorySecurityRealm(domain, site, bindName, bindPassword, server, GroupLookupStrategy.AUTO)

instance.setSecurityRealm(securityRealm)
instance.save()
