package com.alife;

/**
 * Created by macbook on 4/3/17.
 */
public class Constants {

    public static class Spark {
        public static Integer port = 4567;
        public static String responseType = "application/json";
    }

    public static class HTTPCodes {
        public static Integer OK = 200;
    }

    public static class Firebase {
        public static class Credentials {
            public static String SDK = "{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"alife-93165\",\n" +
                    "  \"private_key_id\": \"38b52be072c8f936afedc2a774b6283b5d5db3ba\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDg2dZijsn19Ufj\\nwkUg1MfCsPnf5xVeZ19o/evq2XQkq4FyCh6QCHPhSEvh4QHYCMpravTAnhW8SjPN\\n9eBMOb+RYRn5e7NApgZ1WldjdBb84tNI3tP0WDORbYFMhRWkC7koHJX4EOSh1r5w\\nVXBaeNd/47i95JrlYbPdv/D8aW0KAx8HtF9Yfoao7Fg9dnIfygNEwIcm+nlgfCXm\\n2O/ahI6hgGAMe9VkSDLHdloReenbRZNu12ZCg5JYkSuqBeV3HBkFKMG6TWMkgVXY\\nClYJ2IxTfI9Vin0FnLThfNlcT67pxEI2QDGqxnlr39RJFz8uYhoACG/BcoN0oCos\\n+loo/QhVAgMBAAECggEAAgt5G6RYydfVM4kMv+OvfWHGo/aiBx3BjF7iylv35m14\\n2+SjqoOpKh9SMVeugJxz2s46M5Y8dF3oYrMduxO7XkMXzWEGnEvmOyL7MHhZzSry\\n6PK90rcKoQPx7RQ4wikpIehApOTib2ZYjQT55Ji8vPkBMRjnH7bnv9iDBIig6Tph\\nqsAjazb89aWUc/HFVJUjlfhN9knJj+vipvOQ6eegL0ZOAzz7LE+dfQNsXYMQoJxo\\n0EMvftNgCGONxCZPWtrjQabcL6lb2nCa5IZCZhhiI4oO+0cT4GGKlfTe7McLM0Yt\\n+jL4peiS8YtX8dnXm+NJFGP+0G+MnD3Mcykhf6w78QKBgQD+oxWRXfGc29qBHiIn\\ns8sYdcL2XJNYtIldPEkqZNqQQfoAXTIEBB3tzYmOprDOjQ+7ammMR6kvJ9VwNlvb\\ng8iaWhe9phXC9Kz22UxJZq3PkJYtNzbwMuhRRWpvBH8y5ZgMaI/ShVoT/uziHg5y\\n5ASmM0TNTkeUjDsDr6JmCHc84wKBgQDiDfBXtMqw1JHMKK7NtNB0pBWmAzVdykC2\\nRD1cBcEmXLzM+1FfbLZh6hIARvMkCQpHaBSc+1aVHgL3tqNhEwHWD4bG3JLk/4Z7\\nt835lfHwVpLUqJwTEaqGMBBRlNI2S722f/dPTiImqdGpfnRpnU9KtD+uSqLAm8NZ\\nnwbrMPWjZwKBgQD8LnVovzpPF+mBoF9BJK3KLq6EINEIs9uqy87GPpW68qxued3T\\n3mPppHpMHcfS+B8RhGS9uibS/cdDV4KHly8vtnP2raq1pm46FqCXvSn7+/zPEPTG\\n1BQCkRXElxaGSJ3aBCAT5V99mCXwFsZGgI4eL34/OfxoIK09jE7wcAfu8wKBgQC4\\nkRLsOWPI7zY/T/QxZnFQ2uwGCNaYxlsBtkO3D8e9T7ijUIsG85cR6PBbo5I/mNX4\\nqWUzKw9tXvyjTk6lIsS8Bx9O3KdfK7ac6tzU7HWGetkVorkT5LerKjEYuv7LcBns\\nmRzOdofxs3PJBMN9vAASiYr4/l1WD5d3ZB1dCDN2/wKBgQDC8xe2AF5i+NlTjEVj\\nvajAAV8yYs+FWUNG1UkMBQVMwWcEXZSaH/5WbAxaIk96l6QmbK6a9+pIiEcPTdT6\\nDRZldogZqCXPXvDmqx+MdtftoZh4YiYMIhL+eE1NdvSgK5lUMb2CLfPXx18Qjf1t\\nP6Mnm9OiJ30JtvECk1JLxrK5pA==\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-mqozv@alife-93165.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"115482556086338779226\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://accounts.google.com/o/oauth2/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-mqozv%40alife-93165.iam.gserviceaccount.com\"\n" +
                    "}\n";
        }

        public static class Endpoints {
            public static String BASE = "https://alife-93165.firebaseio.com/";
            public static String emergency = "emergencies";
            public static String user = "users";
        }
    }
}
