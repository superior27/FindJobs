package findjobs.empresa;

import findjobs.Estado;
import findjobs.vaga.Vaga;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-30T23:16:20")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> enderecoEmpresa;
    public static volatile SingularAttribute<Empresa, Long> codigoEmpresa;
    public static volatile ListAttribute<Empresa, Vaga> vaga;
    public static volatile SingularAttribute<Empresa, String> telefoneEmpresa;
    public static volatile SingularAttribute<Empresa, String> nomeEmpresa;
    public static volatile SingularAttribute<Empresa, String> senhaEmpresa;
    public static volatile SingularAttribute<Empresa, String> cargoOfertado;
    public static volatile SingularAttribute<Empresa, String> cnpj;
    public static volatile SingularAttribute<Empresa, String> cidadeEmpresa;
    public static volatile SingularAttribute<Empresa, Estado> estadoEmpresa;

}