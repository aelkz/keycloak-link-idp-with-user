package edu.ohio.ais.keycloak.authentication;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.authentication.ConfigurableAuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;

/**
 * Automatically link the logged in account with an existing
 * or newly created user rather than prompting the user.
 *
 * @author Ilya Kogan
 */
public class LinkIdpLoginAuthenticatorFactory implements AuthenticatorFactory, ConfigurableAuthenticatorFactory {
    public static final String PROVIDER_ID = "link-idp-login-authenticator";
    private static final LinkIdpLoginAuthenticator SINGLETON = new LinkIdpLoginAuthenticator();
    private static AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.DISABLED
    };

    public String getId() {
        return PROVIDER_ID;
    }

    public Authenticator create(KeycloakSession keycloakSession) {
        return SINGLETON;
    }

    public void init(Config.Scope scope) {

    }

    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    public void close() {

    }

    public String getDisplayType() {
        return "Link IDP Login";
    }

    public String getReferenceCategory() {
        return "Link IDP Login";
    }

    public boolean isConfigurable() {
        return false;
    }

    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return REQUIREMENT_CHOICES;
    }

    public boolean isUserSetupAllowed() {
        return false;
    }

    public String getHelpText() {
        return "Automatically link a successful IDP login with any existing (or new) KeyCloak or Federated account.";
    }

    public List<ProviderConfigProperty> getConfigProperties() {
        return null;
    }
}
