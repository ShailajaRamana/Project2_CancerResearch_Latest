package learning.datascience.shailu.project1.dialect;

import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.GetGeneratedKeysDelegate;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.id.PostInsertIdentityPersister;

public class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentitySelectString(String s, String s1, int i) throws MappingException {
        return "select last_insert_rowid()";
    }

    @Override
    public String getIdentityColumnString(int i) throws MappingException {
        return "integer";
    }

}
