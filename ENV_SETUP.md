# Environment Configuration

This project uses environment variables to manage API URLs and configuration across different environments.

## Setup

1. Copy the example environment file:
   ```bash
   cp .env.example .env
   ```

2. Edit `.env` with your actual API URLs:
   ```env
   # Development Environment
   DEV_API_BASE_URL=http://10.0.2.2:8080
   DEV_ENVIRONMENT_NAME=Development

   # Staging Environment  
   STAGING_API_BASE_URL=https://your-staging-api.com
   STAGING_ENVIRONMENT_NAME=Staging

   # Production Environment
   PROD_API_BASE_URL=https://your-production-api.com
   PROD_ENVIRONMENT_NAME=Production

   # Common Configuration
   API_VERSION=v1
   ENABLE_LOGGING_DEV=true
   ENABLE_LOGGING_STAGING=true
   ENABLE_LOGGING_PROD=false
   ```

## Build Variants

- **Development**: `./gradlew assembleDevelopmentDebug`
- **Staging**: `./gradlew assembleStagingDebug`  
- **Production**: `./gradlew assembleProductionDebug`

## Security

- The `.env` file is gitignored and should never be committed
- Use `.env.example` to document required environment variables
- Fallback values are defined in resource files for safety

## Configuration Priority

1. Environment variables (`.env` file)
2. Android resource strings (fallback)
3. Hardcoded defaults (emergency fallback)