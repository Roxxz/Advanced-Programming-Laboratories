/*
  import javax.security.auth.login.Configuration;
  import java.io.File;
  import freemarker.template.*;
  import java.util.*;
  import java.io.*;

  public class ReportCommand extends Catalog{

      ReportCommand(){}

      public void reportCatalog(Catalog catalog) {
          Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
          cfg.setDirectoryForTemplateLoading(new File("/where/you/store/templates"));
          // Recommended settings for new projects:
          cfg.setDefaultEncoding("UTF-8");
          cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
          cfg.setLogTemplateExceptions(false);
          cfg.setWrapUncheckedExceptions(true);
          cfg.setFallbackOnNullLoopVariable(false);
      }
  }
*/