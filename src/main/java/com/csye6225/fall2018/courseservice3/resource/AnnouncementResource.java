package com.csye6225.fall2018.courseservice3.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice3.datamodel.Announcement;
import com.csye6225.fall2018.courseservice3.service.AnnouncementService;

@Path("announcement")
public class AnnouncementResource {

	AnnouncementService annService = new AnnouncementService();

	@GET
	@Path("/board/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Announcement> getAllAnnouncementForBoard(@PathParam("boardId") String boardId) {
		return annService.getAllAnnouncementForBoard(boardId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcement addAnnouncement(Announcement ann) {
		
		return annService.addAnnouncement(ann);
	}

	@PUT
	@Path("/{boardId_announcementId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcement updateAnnouncement(@PathParam("boardId_announcementId") String boardId_announcementId
			, Announcement ann) {
		return annService.updateAnnouncement(boardId_announcementId, ann);
	}

	@GET
	@Path("/{boardId_announcementId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Announcement> getAnnouncementForBoard(@PathParam("boardId_announcementId") String boardId_announcementId) {
		return annService.getAnnouncementForBoard(boardId_announcementId);
	}

	@DELETE
	@Path("/{boardId_announcementId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement deleteAnnouncement(@PathParam("boardId_announcementId") String boardId_announcementId){
		return annService.deleteAnnouncement(boardId_announcementId);
	}
	
	
	
}
