--Insert states
Insert into States (Name) values ('Alabama')
Insert into States (Name) values ('Alaska')
Insert into States (Name) values ('Arizona')
Insert into States (Name) values ('Arkansas')
Insert into States (Name) values ('California')
Insert into States (Name) values ('Colorado')
Insert into States (Name) values ('Connecticut')
Insert into States (Name) values ('Delaware')
Insert into States (Name) values ('Florida')
Insert into States (Name) values ('Georgia')
Insert into States (Name) values ('Hawaii')
Insert into States (Name) values ('Idaho')
Insert into States (Name) values ('Illinois')
Insert into States (Name) values ('Indiana')
Insert into States (Name) values ('Iowa')
Insert into States (Name) values ('Kansas')
Insert into States (Name) values ('Kentucky')
Insert into States (Name) values ('Louisiana')
Insert into States (Name) values ('Maine')
Insert into States (Name) values ('Maryland')
Insert into States (Name) values ('Massachusetts')
Insert into States (Name) values ('Michigan')
Insert into States (Name) values ('Minnesota')
Insert into States (Name) values ('Mississippi')
Insert into States (Name) values ('Missouri')
Insert into States (Name) values ('Montana')
Insert into States (Name) values ('Nebraska')
 Insert into States (Name) values ('Nevada')
 Insert into States (Name) values ('New Hampshire')
 Insert into States (Name) values ('New Jersey')
 Insert into States (Name) values ('New Mexico')
 Insert into States (Name) values ('New York')
 Insert into States (Name) values ('North Carolina')
 Insert into States (Name) values ('North Dakota')
 Insert into States (Name) values ('Ohio')
 Insert into States (Name) values ('Oklahoma')
 Insert into States (Name) values ('Oregon')
 Insert into States (Name) values ('Pennsylvania')
 Insert into States (Name) values ('Rhode Island')
 Insert into States (Name) values ('South Carolina')
 Insert into States (Name) values ('South Dakota')
 Insert into States (Name) values ('Tennessee')
 Insert into States (Name) values ('Texas')
 Insert into States (Name) values ('Utah')
 Insert into States (Name) values ('Vermont')
 Insert into States (Name) values ('Virginia')
 Insert into States (Name) values ('Washington')
 Insert into States (Name) values ('West Virginia')
 Insert into States (Name) values ('Wisconsin')
 Insert into States (Name) values ('Wyoming')
 --Insert categories
 Insert into Categories (Name) values ('Appliances')
 Insert into Categories (Name) values ('Electronics')
 Insert into Categories (Name) values ('Furniture')
 Insert into Categories (Name) values ('Clothing')
 Insert into Categories (Name) values ('Toys & Games')
 Insert into Categories (Name) values ('Vehicles')
 Insert into Categories (Name) values ('Books')
 Insert into Categories (Name) values ('Sports Equipment')
 Insert into Categories (Name) values ('Gardening Tools')
 Insert into Categories (Name) values ('Kitchenware')
 Insert into Categories (Name) values ('Arts & Crafts Supplies')
 Insert into Categories (Name) values ('Other')
 --Insert conditions
 Insert into Conditions (Name) values ('New')
 Insert into Conditions (Name) values ('Used - Excellent Quality')
 Insert into Conditions (Name) values ('Used - Minimal Wear')
 Insert into Conditions (Name) values ('Used - Normal Wear')
 Insert into Conditions (Name) values ('Used - Significant Wear')
 Insert into Conditions (Name) values ('Used - Damaged')
 Insert into Conditions (Name) values ('Not Applicable')
 --Create default user
 Insert into Users (Username, Email, Password, Address, Phone, City, StateID, ZipCode, Geolocation, FirstName, LastName) values ('Lucas','lucasreynolds@email.com','$2a$10$lqLcEaF4/RXvRsmI94rMFeUfzzq0opmveyzsTBf2KNSzWW0adDIIO', '123 North Street', '801-555-1234','Salt Lake City', 44, '12345','POINT(40.524 111.8638)','Lucas','Reynolds')
 --Create default location
 Insert into Locations (Address, City, StateID, ZipCode, Geolocation) values ('123 North Street', 'Salt Lake City', 44, '12345', 'POINT(40.524 111.8638)')
--Create default item
 Insert into Items (Name, Description, CategoryID, ConditionID, DonorID, DateListed, LocationID) values ('Nintendo Switch','Comes with some games such as Mario Cart 8 Deluxe', 2, 2, 1,'2023-11-16',1)
-- make some blog posts
    Insert into BlogPost(Title, Abstract, Content, AuthorID, Category) VALUES ('5 Simple Ways to Live More Sustainably', 'In today’s blog post, we explore five easy changes you can make in your daily life to live more sustainably. From reducing waste to conserving energy, these small steps can make a big difference.', '<div class="blog-post"><h1 class="blog-title">5 Simple Ways to Live More Sustainably</h1><p class="intro-text">In today''''s world, where our environmental footprint is a growing concern, living sustainably has never been more important. Sustainability doesn’t have to be about making big changes; often, it’s the small steps that count. Here are five easy ways you can start living more sustainably and contribute positively to the planet.</p><div class="section"><h2 class="section-title">1. Reduce, Reuse, Recycle</h2><p class="section-content">Start with the basics. Be mindful of what you buy and consume. Try to reduce waste by purchasing products with less packaging, reusing items when possible, and recycling. Remember, every product we buy has an environmental footprint, so think before you buy.</p></div><div class="section"><h2 class="section-title">2. Embrace Second-Hand and Upcycled Goods</h2><p class="section-content">One person’s trash is another’s treasure. Instead of buying new, consider second-hand and upcycled options. Not only does this reduce waste, but it also lessens the demand for new products and their associated environmental impact. Platforms like ''''Sustain n'''' Share'''' are great for finding gently used items or giving a new life to your unused belongings.</p></div><div class="section"><h2 class="section-title">3. Opt for Public Transportation or Carpooling</h2><p class="section-content">Transportation contributes significantly to carbon emissions. By choosing public transportation, carpooling, or even biking, you reduce your carbon footprint. It’s healthier for you and the planet!</p></div><div class="section"><h2 class="section-title">4. Support Local and Sustainable Businesses</h2><p class="section-content">When shopping, prioritize local and sustainable businesses. Local businesses typically have a smaller carbon footprint compared to their larger counterparts. Plus, you’ll be supporting the local economy.</p></div><div class="section"><h2 class="section-title">5. Conserve Energy and Water</h2><p class="section-content">Simple actions like turning off lights when not in use, fixing leaks, taking shorter showers, and using energy-efficient appliances can significantly reduce your water and energy consumption. These small changes can add up to big savings for both the environment and your utility bills.</p></div><p class="conclusion-text">Living sustainably is about making conscious choices that reduce your environmental impact. Start small, and remember, every little bit helps. Let''''s work together to create a healthier planet for future generations!</p></div>', 1, 'Sustainability')
    Insert into BlogPost(Title, Abstract, Content, AuthorID, Category) VALUES ('The Joy of Upcycling: Transform Your Old Items', 'Upcycling is not just a fun hobby, it’s a key part of reducing waste. This post showcases creative ideas for turning old items into something new and exciting.', '<div class="blog-post"><h1 class="blog-title">The Joy of Upcycling: Transform Your Old Items</h1><p class="intro-text">Upcycling isn’t just a crafty buzzword; it’s a key component of reducing waste and living sustainably. By transforming your old items into something new and functional, you''''re not just creating something unique, but you''''re also contributing positively to the environment. Let''''s explore some creative upcycling ideas that are both fun and eco-friendly.</p><div class="section"><h2 class="section-title">1. Old T-Shirts into Tote Bags</h2><p class="section-content">Turn your old, unused t-shirts into handy tote bags. This simple upcycling project doesn’t require advanced sewing skills and gives you a sustainable way to carry groceries, books, or anything else.</p></div><div class="section"><h2 class="section-title">2. Glass Jars as Decorative Vases</h2><p class="section-content">Glass jars of all shapes and sizes can be transformed into beautiful decorative vases. Just clean them up, maybe add a coat of paint, and they’re ready to brighten up any corner of your home with fresh flowers.</p></div><div class="section"><h2 class="section-title">3. Transforming Furniture</h2><p class="section-content">Got an old chair or table? Give it a new lease of life with some sandpaper and paint. Upcycled furniture not only adds character to your home but also avoids unnecessary waste.</p></div><div class="section"><h2 class="section-title">4. Repurposed Books</h2><p class="section-content">Turn old books into art, photo frames, or even hidden storage boxes. These creative ideas can give a new purpose to books that are damaged or no longer read.</p></div><div class="section"><h2 class="section-title">5. Denim Jeans Into Just About Anything</h2><p class="section-content">Old denim jeans can be upcycled into a variety of items including aprons, pillow covers, or even a new purse. Denim is durable and versatile, making it perfect for a variety of DIY upcycling projects.</p></div><p class="conclusion-text">Upcycling is a fantastic way to reduce waste and express your creativity. Start with simple projects and gradually take on more complex ones as your skills improve. Happy upcycling!</p></div>', 1, 'Upcycling')
    Insert into BlogPost(Title, Abstract, Content, AuthorID, Category) VALUES ('Community Sharing: More Than Just an Exchange', 'Community sharing goes beyond just exchanging items. It''s about building connections, supporting others, and creating a more inclusive community. Read more about the impact of sharing in our latest post.', '<div class="blog-post"><h1 class="blog-title">Community Sharing: More Than Just an Exchange</h1><p class="intro-text">Community sharing goes beyond the simple act of exchanging items. It''s about fostering a sense of belonging, supporting each other, and building a sustainable future together. In this post, we delve into how community sharing creates more than just material benefits.</p><div class="section"><h2 class="section-title">Building Connections</h2><p class="section-content">When we share with others in our community, we create connections that go beyond the transactional. Sharing items can open doors to new friendships, strengthen community bonds, and create a sense of belonging.</p></div><div class="section"><h2 class="section-title">Supporting Each Other</h2><p class="section-content">Community sharing is an act of support. It''s about helping those in need, whether it''s offering essential items to families or providing tools for a local project. This support is the backbone of a strong, resilient community.</p></div><div class="section"><h2 class="section-title">Reducing Environmental Impact</h2><p class="section-content">Sharing within the community significantly reduces waste and minimizes our collective environmental footprint. By reusing and sharing, we reduce the demand for new products and contribute to a more sustainable world.</p></div><div class="section"><h2 class="section-title">Encouraging Sustainable Living</h2><p class="section-content">Community sharing encourages a sustainable lifestyle. It makes us more mindful of our consumption habits and inspires us to think about the lifecycle of the items we use.</p></div><div class="section"><h2 class="section-title">Inclusivity and Accessibility</h2><p class="section-content">Sharing initiatives make resources more accessible to everyone in the community, regardless of their economic status. This inclusivity is fundamental to building a community where everyone has what they need to thrive.</p></div><p class="conclusion-text">Community sharing is a powerful tool for building stronger, more sustainable, and more inclusive communities. It''s a simple concept with profound impacts, both materially and socially. Let''s embrace the spirit of sharing and strengthen our communal ties.</p></div>', 1, 'Community')
    Insert into BlogPost(Title, Abstract, Content, AuthorID, Category) VALUES ('Reducing Your Carbon Footprint: A Guide', 'Every action we take has an impact on our carbon footprint. This guide provides practical tips on reducing your carbon footprint and contributing to a healthier planet.','<div class="blog-post"><h1 class="blog-title">Reducing Your Carbon Footprint: A Guide</h1><p class="intro-text">Every action we take leaves a mark on our planet, especially when it comes to our carbon footprint. Making conscious choices to reduce our carbon footprint is crucial for a healthier planet. This guide will provide practical tips to help you make a positive environmental impact.</p><div class="section"><h2 class="section-title">Understand Your Impact</h2><p class="section-content">The first step in reducing your carbon footprint is understanding it. Tools like online carbon footprint calculators can help you estimate your impact based on your lifestyle choices, including travel, energy consumption, and diet.</p></div><div class="section"><h2 class="section-title">Travel Smart</h2><p class="section-content">Transportation is a significant contributor to carbon emissions. Opt for public transit, carpooling, biking, or walking when possible. When traveling long distances, consider trains instead of planes, and plan direct routes to minimize travel time and fuel consumption.</p></div><div class="section"><h2 class="section-title">Energy Efficiency at Home</h2><p class="section-content">Making your home more energy-efficient is a great way to reduce your carbon footprint. Use LED light bulbs, invest in energy-efficient appliances, and consider smart thermostats. Also, look into renewable energy options like solar panels.</p></div><div class="section"><h2 class="section-title">Sustainable Eating Habits</h2><p class="section-content">Your diet can significantly impact your carbon footprint. Eating more plant-based foods, reducing meat consumption, and buying local and organic products can reduce your environmental impact. Minimizing food waste is also key.</p></div><div class="section"><h2 class="section-title">Reduce, Reuse, Recycle</h2><p class="section-content">Adopting the principles of reduce, reuse, and recycle can significantly cut down your carbon footprint. Be mindful of your consumption, choose sustainable products, and recycle whenever possible.</p></div><p class="conclusion-text">Reducing your carbon footprint isn’t just good for the planet – it often leads to a healthier, more mindful, and potentially cost-effective lifestyle. Start with small changes and gradually incorporate more sustainable practices into your daily life.</p></div>', 1, 'Environment')
    Insert into BlogPost (Title, Abstract, Content, AuthorID, Category) VALUES ('The Environmental Impact of Digital Waste', 'Digital waste is an often overlooked aspect of environmental sustainability. In this post, we delve into what digital waste is and how we can reduce it.', '<div class="blog-post"><h1 class="blog-title">The Environmental Impact of Digital Waste</h1><p class="intro-text">In our increasingly digital world, electronic waste, or ''''e-waste'''', has become a significant environmental challenge. Digital waste not only clutters our physical space but also has profound implications for our planet. This post explores what digital waste is and how we can minimize its impact.</p><div class="section"><h2 class="section-title">Understanding Digital Waste</h2><p class="section-content">Digital waste refers to discarded electronic devices and gadgets, like smartphones, computers, and TVs. These items often contain hazardous materials that can harm the environment if not disposed of properly. They also embody the energy and resources used in manufacturing.</p></div><div class="section"><h2 class="section-title">Reduce and Reuse</h2><p class="section-content">One of the most effective ways to combat digital waste is to reduce our consumption of electronics. Consider repairing devices instead of replacing them, buy refurbished products, and donate or sell gadgets you no longer need.</p></div><div class="section"><h2 class="section-title">Recycling Electronic Waste</h2><p class="section-content">Properly recycling e-waste is crucial. Look for certified e-waste recycling centers or programs that can handle these materials responsibly. Many manufacturers also offer take-back programs for their products.</p></div><div class="section"><h2 class="section-title">Responsible Disposal</h2><p class="section-content">When electronic devices reach the end of their life, ensure they are disposed of responsibly. This often means taking them to a facility that can safely recycle or dispose of the components.</p></div><div class="section"><h2 class="section-title">Educate and Advocate</h2><p class="section-content">Spread awareness about the importance of managing digital waste. Advocate for policies and practices that support sustainable production, consumption, and disposal of electronic devices.</p></div><p class="conclusion-text">Managing digital waste is a critical aspect of protecting our environment. By taking thoughtful steps to reduce, reuse, recycle, and responsibly dispose of our electronics, we can all contribute to a more sustainable future.</p></div>', 1, 'Digital Sustainability')
