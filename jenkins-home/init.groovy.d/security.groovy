import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

// Enable the ACL strategy to if you can login your an admin
def strategy = new hudson.security.FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.save()
