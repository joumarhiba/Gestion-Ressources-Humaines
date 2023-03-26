export const environment = {
    production: false,
    keycloak: {
        issuer: 'http://localhost:8080/auth/realms/easyRH',
        redirectUri: 'http://localhost:4200',
        clientId: 'easyRH-app',
        scope: 'openid profile email offline_access'
    }
}