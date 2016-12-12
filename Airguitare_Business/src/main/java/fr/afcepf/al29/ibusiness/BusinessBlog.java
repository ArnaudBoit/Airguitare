package fr.afcepf.al29.ibusiness;

import fr.afcepf.al29.airguitare.api.IDAOArticleBlog;
import fr.afcepf.al29.airguitare.api.IDAOBlog;
import fr.afcepf.al29.airguitare.api.IDAOCommentaireBlog;
import fr.afcepf.al29.airguitare.api.IDAOThemeArticle;
import fr.afcepf.al29.business.IBusinessBlog;

/**
 * 
 */
public class BusinessBlog implements IBusinessBlog {


    /**
     * 
     */
    private IDAOBlog DAOBlog;

    /**
     * 
     */
    private IDAOCommentaireBlog DAOCommentaireBlog;
    
    /**
     * 
     */
    private IDAOArticleBlog DAOArticleBlog;
    
    private IDAOThemeArticle DAOThemeArticle;

}