package com.ghofranjdaradkh.AuthenticationSite;

import com.ghofranjdaradkh.AuthenticationSite.models.Posts;
import com.ghofranjdaradkh.AuthenticationSite.models.SiteUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class AuthenticationSiteApplicationTests {

	@Test
	public void testConstructor() {
		SiteUser siteUser=new SiteUser();
		assertNull(siteUser.getId());
		assertNull(siteUser.getUsername());
		assertNull(siteUser.getPassword());
		assertNull(siteUser.getPosts());
	}

	@Test
	public void testConstructorPosts() {
		Posts posts=new Posts();
		assertEquals(0, posts.getId());
		assertNull(posts.getSiteUser());
		assertNull(posts.getText());

	}



}
